document.addEventListener('DOMContentLoaded', function() {
    const menuList = document.getElementById('menuList');
    const tableCards = document.querySelectorAll('#tables .table-card');
    let draggedItem = null;
    // Initialize tables object
    const tables = {};
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
                <span class="item-price">Rs. ${itemPrice}</span>
            `;
            menuList.appendChild(menuItemLi);

            // Add dragstart listener to newly added item
            menuItemLi.addEventListener('dragstart', function(event) {
                draggedItem = event.target;
                event.dataTransfer.setData('text/plain', draggedItem.dataset.name);
            });
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

                    // Initialize table if not already
                    if (!tables[tableId]) {
                        tables[tableId] = {
                            orders: {},
                            cost: 0,
                            items: 0
                        };
                    }
                    // Update table with new order
                    addItemToTable(tableId, itemName, itemPrice);
                    // Re-add the item to the menu
                    reAddItemToMenu(itemName, itemPrice);

                    draggedItem = null;
                }
            });
        });
    }
    setupTableCards(); // Initialize table cards on load
    // Function to add item to a table
    function addItemToTable(tableId, itemName, itemPrice) {
        const table = tables[tableId];
        if (!table.orders[itemName]) {
            table.orders[itemName] = { name: itemName, price: parseFloat(itemPrice), servings: 1 };
        } else {
            table.orders[itemName].servings += 1;
        }
        table.cost += parseFloat(itemPrice);
        table.items += 1;

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
});
