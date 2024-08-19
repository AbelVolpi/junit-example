import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CustomerSystemTest {

    private lateinit var customerSystem: CustomerSystem

    @BeforeEach
    fun setup() {
        customerSystem = CustomerSystem()
    }

    @Test
    fun `should successfully register a customer`() {
        val customer = Customer("John", "john@example.com", "123456789")
        val result = customerSystem.registerCustomer(customer)
        assertTrue(result)
    }

    @Test
    fun `should not register a customer with duplicate email`() {
        val customer1 = Customer("John", "john@example.com", "123456789")
        val customer2 = Customer("Mary", "john@example.com", "987654321")
        customerSystem.registerCustomer(customer1)
        val result = customerSystem.registerCustomer(customer2)
        assertFalse(result)
    }

    @Test
    fun `should list registered customers`() {
        val customer1 = Customer("John", "john@example.com", "123456789")
        val customer2 = Customer("Mary", "mary@example.com", "987654321")
        customerSystem.registerCustomer(customer1)
        customerSystem.registerCustomer(customer2)
        val list = customerSystem.listCustomers()
        assertEquals(2, list.size)
        assertEquals(customer1, list[0])
        assertEquals(customer2, list[1])
    }

    @Test
    fun `should edit an existing customer's details`() {
        val customer = Customer("John", "john@example.com", "123456789")
        customerSystem.registerCustomer(customer)
        val result = customerSystem.editCustomer("john@example.com", "John Smith", "987654321")
        assertTrue(result)
        val editedCustomer = customerSystem.listCustomers().first { it.email == "john@example.com" }
        assertEquals("John Smith", editedCustomer.name)
        assertEquals("987654321", editedCustomer.phone)
    }

    @Test
    fun `should not edit a non-existent customer`() {
        val result = customerSystem.editCustomer("nonexistent@example.com", "Name", "Phone")
        assertFalse(result)
    }

    @Test
    fun `should delete an existing customer`() {
        val customer = Customer("John", "john@example.com", "123456789")
        customerSystem.registerCustomer(customer)
        val result = customerSystem.deleteCustomer("john@example.com")
        assertTrue(result)
        assertTrue(customerSystem.listCustomers().isEmpty())
    }

    @Test
    fun `should not delete a non-existent customer`() {
        val result = customerSystem.deleteCustomer("nonexistent@example.com")
        assertFalse(result)
    }
}