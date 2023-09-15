package br.com.projeto.pizzaria.configuracoes;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Data
public class Conf {

        @Value("${password}")
        private String password;

}
