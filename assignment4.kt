fun main() {
    val orders = listOf(
        Order("Order1", 9, 15.0),
        Order("Order2", 4, 20.0),
        Order("Order3", 7, 10.0)
    )

    val CalculateTotalValue = CalculateTotalValue(orders[0])
    println("Total Order Value is : ${"%.3f".format(CalculateTotalValue)}")


    val TotalOrderValue = CalculateTotalOrderValue(orders)
    println("Total Order Value is : ${"%.3f".format(TotalOrderValue)}")



    val HighestValueOrder = FindHighestValueOrder(orders)
    if (HighestValueOrder != null) {
        println("Highest Value Order is : ${HighestValueOrder.productName}, Value: ${"%.3f".format(CalculateTotalValue(HighestValueOrder))}")
    } else {
        println("No orders found.")
    }


}


data class Order(
    val productName: String,
    val quantity: Int,
    val unitPrice: Double){
}

fun CalculateTotalValue(order: Order): Double {
    return order.quantity * order.unitPrice
}

fun CalculateTotalOrderValue(orders: List<Order>): Double {
    return orders.map { CalculateTotalValue(it) }.reduceOrNull { acc, value -> acc + value } ?: 0.0
}

fun FindHighestValueOrder(orders: List<Order>): Order? {
    return orders.maxByOrNull { CalculateTotalValue(it) }
}