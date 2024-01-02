package com.example.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration //le digo a spring que esta es una clase de configuracion
@EnableWebSecurity //establesco que esta va a ser la configuracion de la web
public class SecurityConfig {

    
    public AuthenticationSuccessHandler successHandler(){//en caso de que funcione el formulario
        return ((request, response, authentication) -> {
            response.sendRedirect("/v1/index");//direcciona a esta url
        });
    }

    @Bean        //este objeto funciona para configurar la aplicacion
    public SecurityFilterChain filterChain(HttpSecurity HttpSecurity)throws Exception{
        return HttpSecurity
                .authorizeHttpRequests(autorize -> autorize// configuramos las URL protegidas y cuales no
                        .requestMatchers("/v1/index2").permitAll()//parametros: arreglo de strings de urls que no van a necesitar autorizacion
                        .anyRequest().authenticated()//  cualquier otra url tiene que estar autenticada
                )
                .formLogin(form -> {
                    form.successHandler(successHandler());//si funciona realiza el metodo
                    form.permitAll();
                })
                .sessionManagement(sesion -> {
                    sesion.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
                    /*opciones:
                        ALWAYS: va a crear en caso de que no exista una, sino reutiliza la existente
                        IF_REQUIRED: hace lo mismo que ALWAYS pero es mas estricto, evalua si es necesario crear
                        NEVER: no crea sesion pero si usa una existente
                        STATELESS: no guarda ningun dato en sesion
                    */
                    sesion.invalidSessionUrl("/login");//si se crea una sesion erronea a donde se redirije al user
                    sesion.maximumSessions(1);//maximo de sesiones por usuarios
                    sesion.sessionFixation().migrateSession();
                    /* migrateSession(): cuando detecta un ataque de session genera otro id de sesion
                       newSession(): hace lo mismo que migrateSession pero no copia los datos de usuario
                       none(): no realiza nada
                    */

                })
                .build();


        // .csrf(cs -> cs.disable()): desactiva (cross-site request Forgery) es una proteccion de spring para la
        // comunicacion del navegador con el servidor, ante interseccion a travez de un formulario
    }

}
