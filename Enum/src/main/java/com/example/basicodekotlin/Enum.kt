package com.example.basicodekotlin

//Aguardando aprovação
//realizado
//Pagamento_confirmado
enum class StatusPedido{
    AGURDANDO_APROVACAO,
    PEDIDO_REALIZADO,
    PAGAMENTO_CONFIRMADO,
    PEDIDO_ENVIADO,
    PEDIDO_ENTREGUE

}
class Pedido( var total: Double = 0.0,
              var intens : String = "",
              var statusPedido : StatusPedido = StatusPedido.AGURDANDO_APROVACAO
){


}

fun main(){
    // Mudando para ordinal
    println("Status do Pedido: ${StatusPedido.AGURDANDO_APROVACAO.ordinal}")
    // Tela de compras
val pedido = Pedido(125.9,"Camiseta, livro")
    // pagamento com cartão
    pedido.statusPedido = StatusPedido.PEDIDO_REALIZADO

    // Historico de compra
    if (pedido.statusPedido == StatusPedido.PEDIDO_REALIZADO){
        println("O seu pedido foi realizado")
    } else if (pedido.statusPedido == StatusPedido.PAGAMENTO_CONFIRMADO){
        println("O seu pagamento foi confirmado")
    }
}