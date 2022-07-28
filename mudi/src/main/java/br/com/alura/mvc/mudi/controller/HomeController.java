package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Código limpo: Habilidades práticas do Agile Software Capa comum");
        pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/41aHzYSXZkL._SX380_BO1,204,203,200_.jpg");
        pedido.setDescricao("Robert C. “Uncle Bob” Martin é profissional em softwares desde 1970 e consultor de software desde 1990. Ele é o fundador e o presidente da Object Mentor, Inc., uma equipe de consultores experientes que" +
                " orientam seus clientes no mundo todo em C++, Java, C#, Ruby, OO, Padrões de Projeto, UML, Metodologias Agile e eXtreme Programming.");
        pedido.setValorNegociado(new BigDecimal(75.50));
        pedido.setUrlProduto("https://www.amazon.com.br/Código-limpo-Robert-C-Martin/dp/8576082675/ref=sr_1_2?keywords=cle" +
                "an+code&qid=1658973496&sprefix=clea%2Caps%2C220&sr=8-2&ufe=app_do%3Aamzn1.fos.6d798eae-cadf-45de-946a-f477d47705b9");
        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

}
