Class: Order

    Responsibilities: 
        - tore customer details, items, and pricing.
        - Provide access to order data for other classes.
    Collaborators: 
        None

Class: TaxCalculator

    Responsibilities: 
        - Calculate tax based on a provided price.
        - Allow for easy updates to tax rates.

    Collaborators: 
        None

Class: DiscountService

    Responsibilities: 
        - Determine if a discount applies based on order total.
        - Calculate the final discounted price.

    Collaborators: 
        Order

Class: OrderRepository

    Responsibilities: 
        - Handle data persistence (saving the order to a file or database).
        - Format the order data for storage.

    Collaborators: 
        Order

Class: NotificationService

    Responsibilities: 
        - Format and send order confirmation emails.
        - Handle communication with the customer.

    Collaborators: 
        Order

Class: OrderProcessor (Refactored)

    Responsibilities: 
        - Coordinate the workflow between calculation, storage, and notification.
        - Act as the controller for the order lifecycle.

    Collaborators: 
        Order, TaxCalculator, DiscountService, OrderRepository, NotificationService