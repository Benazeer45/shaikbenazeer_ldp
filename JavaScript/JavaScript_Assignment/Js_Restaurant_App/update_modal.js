document.addEventListener('DOMContentLoaded', function() {
    const menuList = document.getElementById('menuList');
    const tableCards = document.querySelectorAll('#tables .table-card');
    let draggedItem = null;
  // Initialize tables object
  const tables = {
    table1: { orders: {}, cost: 0, items: 0 },
    table2: { orders: {}, cost: 0, items: 0 },
    table3: { orders: {}, cost: 0, items: 0 },
};
    // Modal elements
    const orderModal = document.getElementById('orderModal');
    const modalTitle = document.getElementById('modalTitle');
    const orderDetails = document.getElementById('orderDetails');
    let highlightedTableId = null;

    // Add event listeners to menu items
    function setupMenuItems() {
        document.querySelectorAll('#menuList .menu-item').forEach(item => {
            item.addEventListener('dragstart', function(event) {
                draggedItem = event.target;
                event.dataTransfer.setData('text/plain', draggedItem.dataset.name);
            });
        });
    }
    setupMenuItems(); // Initialize menu items on load

    // Function to re-add item to the menu
    function reAddItemToMenu(itemName, itemPrice) {
        const existingItem = menuList.querySelector(`[data-name="${itemName}"]`);
        if (!existingItem) {
            const menuItemLi = document.createElement('li');
            menuItemLi.className = 'menu-item';
            menuItemLi.dataset.name = itemName;
            menuItemLi.dataset.price = itemPrice;
            menuItemLi.draggable = true;
            menuItemLi.innerHTML = `
                <span class="item-name">${itemName}</span>
            `;
            menuList.appendChild(menuItemLi);

            // Add dragstart listener to newly added item
            menuItemLi.addEventListener('dragstart', function(event) {
                draggedItem = event.target;
                event.dataTransfer.setData('text/plain', draggedItem.dataset.name);
            });
        }
    }

    // Function to add item to a table
    function addItemToTable(tableId, itemName, itemPrice) {
        const table = tables[tableId];
        if (!table.orders[itemName]) {
            table.orders[itemName] = { name: itemName, price: parseFloat(itemPrice), servings: 1 };
        } else {
            table.orders[itemName].servings += 1;
        }
        // Recalculate total cost and number of items
        table.cost = Object.values(table.orders).reduce((total, order) => total + (order.price * order.servings), 0);
        table.items = Object.values(table.orders).reduce((total, order) => total + order.servings, 0);

        updateTableCard(tableId);
    }

    // Function to update the table card
    function updateTableCard(tableId) {
        const tableCard = document.getElementById(tableId);
        const table = tables[tableId];
        tableCard.innerHTML = `
            <h3>${tableId.replace('table', 'Table ')}</h3>
            <div class="table-info">
                Rs. ${table.cost.toFixed(2)} | Total items: ${table.items}
            </div>
        `;
    }

    function openModal(tableId) {
        highlightedTableId = tableId;
        const table = tables[tableId];
        if (!table || Object.keys(table.orders).length === 0) {
            // If there are no orders for this table, display a message or leave the modal empty
            modalTitle.textContent = `Table - ${tableId.replace('table', '')} | Order Details`;
            orderDetails.innerHTML = `<tr><td colspan="4">No items in this table.</td></tr>`;
            orderModal.style.display = 'block';
            return;
        }
        // Update modal header
        modalTitle.textContent = `Table - ${tableId.replace('table', '')} | Order Details`;
        // Clear previous order details
        orderDetails.innerHTML = '';
        // Add new order details to modal
        let index = 0;
        for (const itemName in table.orders) {
            const order = table.orders[itemName];
            const row = document.createElement('tr');
            row.className = 'order-detail';
            row.innerHTML = `
                <td class="order-detail-sno">${index + 1}</td>
                <td class="order-detail-item">${order.name}</td>
                <td class="order-detail-price">Rs. ${(order.price * order.servings).toFixed(2)}</td>
                <td class="order-detail-actions">
                    <div class="quantity-container">
                        <div class="quantity-heading">Number of Servings:</div>
                        <input type="number" class="quantity" value="${order.servings}" data-id="${itemName}">
                        <div class="actions-container">
                            <span class="dustbin" data-id="${itemName}">&#x1F5D1;</span>
                        </div>
                    </div>
                </td>
            `;
            orderDetails.appendChild(row);
            index++;
        }
        // Recalculate total cost (in case any changes were made outside the modal)
        table.cost = Object.values(table.orders).reduce((total, order) => total + (order.price * order.servings), 0);
        // Add total row
        const totalRow = document.createElement('tr');
        totalRow.className = 'order-detail total-row';
        totalRow.innerHTML = `
            <td colspan="2"></td>
            <td class="total-cell">Total: <br>Rs. ${table.cost.toFixed(2)}</td>
            <td></td>
        `;
        orderDetails.appendChild(totalRow);
        // Store the total cost
        totalCost = table.cost;
                // Add "Generate Bill" button
                const generateBillButton = document.createElement('button');
                generateBillButton.id = 'generateBillBtn';
                generateBillButton.className = 'generate-bill-btn'; // Add this class
                generateBillButton.textContent = 'Generate Bill';
                orderDetails.appendChild(generateBillButton);      
        // Show the modal
        orderModal.style.display = 'block';
    }
    
    // Function to close the modal
    function closeModal() {
        orderModal.style.display = 'none';
    }

    // Function to update item quantity and price
    function updateItemQuantity(itemName, newQuantity) {
        const table = tables[highlightedTableId];
        if (table && table.orders[itemName]) {
            const item = table.orders[itemName];
            item.servings = newQuantity;
            // Recalculate total cost and number of items
            table.cost = Object.values(table.orders).reduce((total, order) => total + (order.price * order.servings), 0);
            table.items = Object.values(table.orders).reduce((total, order) => total + order.servings, 0);
            // Update table card
            updateTableCard(highlightedTableId);
            // Update the modal
            const modalRow = orderDetails.querySelector(`[data-id="${itemName}"]`).closest('tr');
            if (modalRow) {
                modalRow.querySelector('.order-detail-price').textContent = `Rs. ${(item.price * item.servings).toFixed(2)}`;
            }
            // Update the total cost in the modal
            orderDetails.querySelector('.total-cell').innerHTML = `Total: <br>Rs. ${table.cost.toFixed(2)}`;
        }
    }

    // Function to delete an item
    function deleteItem(itemName) {
        const table = tables[highlightedTableId];
        if (table && table.orders[itemName]) {
            delete table.orders[itemName];
            // Recalculate total cost and number of items
            table.cost = Object.values(table.orders).reduce((total, order) => total + (order.price * order.servings), 0);
            table.items = Object.values(table.orders).reduce((total, order) => total + order.servings, 0);
            updateTableCard(highlightedTableId);
            openModal(highlightedTableId); // Ensure modal is refreshed with new data
        }
    }

    // Add event listeners to table cards
    function setupTableCards() {
        tableCards.forEach(card => {
            card.addEventListener('dragover', function(event) {
                event.preventDefault();
                card.classList.add('drag-over');
            });
            card.addEventListener('dragleave', function(event) {
                card.classList.remove('drag-over');
            });
            card.addEventListener('drop', function(event) {
                event.preventDefault();
                card.classList.remove('drag-over');
                if (draggedItem) {
                    const tableId = card.id;
                    const itemName = draggedItem.dataset.name;
                    const itemPrice = draggedItem.dataset.price;
                    // Update table with new order
                    addItemToTable(tableId, itemName, itemPrice);
                    // Re-add the item to the menu
                    reAddItemToMenu(itemName, itemPrice);
                    draggedItem = null;
                }
            });
            // Click event to open modal
            card.addEventListener('click', function() {
                const tableId = card.id;
                openModal(tableId);
            });
        });
    }

    setupTableCards(); // Initialize table cards on load

    // Event listeners for modal close button and quantity arrows
    document.querySelector('.close').addEventListener('click', function() {
        closeModal();
    });

    // Prevent modal close when clicking outside
    orderModal.addEventListener('click', function(event) {
        if (event.target === orderModal) {
            event.stopPropagation(); // Prevent modal from closing
        }
    });

    orderDetails.addEventListener('input', function(event) {
        const target = event.target;
        if (target.classList.contains('quantity')) {
            const itemName = target.dataset.id;
            const newQuantity = parseInt(target.value, 10);
            if (newQuantity >= 1) {
                updateItemQuantity(itemName, newQuantity);
            } else {
                target.value = 1; // Reset to 1 if less than 1
                alert('Number of servings must be at least 1.');
            }
        }
    });

    orderDetails.addEventListener('click', function(event) {
        const target = event.target;
        if (target.classList.contains('dustbin')) {
            const itemName = target.dataset.id;
            deleteItem(itemName);
        }
    });

    // Event listener for "Generate Bill" button click
    orderDetails.addEventListener('click', function(event) {
        if (event.target.id === 'generateBillBtn') {
            const table = tables[highlightedTableId];
        if (table && Object.keys(table.orders).length > 0) {
            // Display the bill total for the specific table
            alert(`Total Bill for Table ${highlightedTableId.replace('table', '')}: Rs. ${table.cost.toFixed(2)}`);
            
            // Clear the orders, cost, and items for the current table only
            table.orders = {};
            table.cost = 0;
            table.items = 0;

            // Update the specific table card to reflect the cleared state
            updateTableCard(highlightedTableId);

            // Reset the table card color to normal (remove any active or highlighted class)
            const tableCard = document.getElementById(highlightedTableId);
            tableCard.classList.remove('active'); // Remove the active class, if any
            
            // Optionally, set the background color directly if needed
            tableCard.style.backgroundColor = '#f5f5f5'; // Replace with your default color

            // Close the modal
            closeModal();
        } else {
            alert('No items in the table.');
        }   }
    });
});