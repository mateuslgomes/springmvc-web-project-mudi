package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.RequestNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String formulario(RequestNovoPedido request) {
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequestNovoPedido request, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        }
        Pedido pedido = request.toPedido();
        pedidoRepository.save(pedido);
        return "pedido/formulario";
    }
}
