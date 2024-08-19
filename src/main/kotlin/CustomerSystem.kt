class CustomerSystem {
    private val customers = mutableListOf<Customer>()

    fun registerCustomer(customer: Customer): Boolean {
        return if (customers.none { it.email == customer.email }) {
            customers.add(customer)
            true
        } else {
            false
        }
    }

    fun editCustomer(email: String, newName: String, newPhone: String): Boolean {
        val customer = customers.find { it.email == email }
        return if (customer != null) {
            customer.name = newName
            customer.phone = newPhone
            true
        } else {
            false
        }
    }

    fun deleteCustomer(email: String): Boolean {
        val customer = customers.find { it.email == email }
        return if (customer != null) {
            customers.remove(customer)
            true
        } else {
            false
        }
    }

    fun listCustomers(): List<Customer> {
        return customers.toList()
    }

}