fun main() {
    val customerSystem = CustomerSystem()

    customerSystem.registerCustomer(Customer("John", "john@example.com", "123456789"))
    customerSystem.registerCustomer(Customer("Mary", "mary@example.com", "987654321"))

    // Duplicated case
    val duplicateCustomer = Customer("John Duplicate", "john@example.com", "000000000")
    println("Duplicate registration successful: ${customerSystem.registerCustomer(duplicateCustomer)}")

    // List customers
    println("\nRegistered customers:")
    customerSystem.listCustomers().forEach { println(it) }

    // Editing customer
    customerSystem.editCustomer("john@example.com", "John Smith", "999888777")
    println("\nAfter editing John:")
    customerSystem.listCustomers().forEach { println(it) }

    // Excluding customer
    customerSystem.deleteCustomer("mary@example.com")
    println("\nAfter deleting Mary:")
    customerSystem.listCustomers().forEach { println(it) }
}
