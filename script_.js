document.addEventListener('DOMContentLoaded', function() {
    let draggedItem = null;

const searchMenuInput = document.getElementById('searchMenu');
const searchTableInput = document.getElementById('searchTable');
const clearMenuSearch = document.getElementById('clearMenuSearch');
const clearTableSearch = document.getElementById('clearTableSearch');
const menuList = document.getElementById('menuList');
const tableCards = document.querySelectorAll('#tablesContainer .table-card');
const categories = ['entree', 'main course', 'desserts', 'appetizers', 'beverages'];
const modal = document.getElementById('orderModal');
const closeModal = modal.querySelector('.close');
const orderDetails = document.getElementById('orderDetails');
const overlay = document.getElementById('overlay');

// Immediately hide modal and overlay to avoid flicker on page load
modal.style.display = 'none';
overlay.style.display = 'none';

// Function to filter menu items based on search query
function filterMenuItems(query) {
    const items = Array.from(menuList.children);
    const lowerCaseQuery = query.toLowerCase();
    let hasVisibleItems = false;

    items.forEach(item => {
        const itemNameElement = item.querySelector('.item-name');
        const itemCategory = item.getAttribute('data-category');

        if (itemNameElement) {
            const itemName = itemNameElement.textContent.toLowerCase();

            if (categories.includes(lowerCaseQuery)) {
                if (itemCategory === lowerCaseQuery) {
                    item.style.display = '';
                    hasVisibleItems = true;
                } else {
                    item.style.display = 'none';
                }
            } else {
                if (itemName.includes(lowerCaseQuery) || itemCategory.includes(lowerCaseQuery)) {
                    item.style.display = '';
                    hasVisibleItems = true;
                } else {
                    item.style.display = 'none';
                }
            }
        } else {
            item.style.display = '';
        }
    });

    const noResults = menuList.querySelector('.no-results');
    if (hasVisibleItems) {
        if (noResults) noResults.remove();
    } else {
        if (!noResults) {
            const noResultsItem = document.createElement('li');
            noResultsItem.textContent = 'No results found';
            noResultsItem.className = 'no-results';
            menuList.appendChild(noResultsItem);
        }
    }
}

// Function to filter table cards based on search query
function filterTableItems(query) {
    const lowerCaseQuery = query.toLowerCase();
    let hasVisibleTables = false;

    tableCards.forEach(card => {
        const tableName = card.querySelector('h3').textContent.toLowerCase();
        if (tableName.includes(lowerCaseQuery)) {
            card.style.display = '';
            hasVisibleTables = true;
        } else {
            card.style.display = 'none';
        }
    });

    if (!hasVisibleTables && query === '') {
        tableCards.forEach(card => card.style.display = '');
    }
}

// Function to sort menu items alphabetically
function sortMenuItems() {
    const items = Array.from(menuList.children);
    const sortedItems = items
        .filter(item => item.querySelector('.item-name'))
        .sort((a, b) => {
            const nameA = a.querySelector('.item-name').textContent.toLowerCase();
            const nameB = b.querySelector('.item-name').textContent.toLowerCase();
            return nameA.localeCompare(nameB);
        });

    while (menuList.firstChild) {
        menuList.removeChild(menuList.firstChild);
    }

    sortedItems.forEach(item => menuList.appendChild(item));
}

// Function to update table information (total cost and number of items)
function updateTableInfo(tableCard) {
const tableId = tableCard.id; // Get the ID of the table card
if (tableId === 'table1' || tableId === 'table2' || tableId === 'table3') { // Check if this is the specific table we want to display
    const items = tableCard.querySelectorAll('.order-item');
    let totalItems = 0;
    let totalCost = 0;

    items.forEach(item => {
        const itemPrice = parseFloat(item.getAttribute('data-price'));
        const itemQuantity = parseInt(item.querySelector('.item-quantity').textContent);
        totalItems += itemQuantity;
        totalCost += itemPrice * itemQuantity;
    });

    const info = tableCard.querySelector('.table-info');
    info.textContent = `Rs. ${totalCost.toFixed(2)} | Total items: ${totalItems}`;
} else {
    // Hide information for other tables
    const info = tableCard.querySelector('.table-info');
    info.textContent = '';
}
}

// Function to show order details in the modal
function showOrderDetails(tableCard) {
    const items = tableCard.querySelectorAll('.order-item');
    let detailsHtml = '';
    let totalPrice = 0;

    items.forEach((item, index) => {
        const itemName = item.querySelector('.item-name').textContent;
        const itemPrice = parseFloat(item.getAttribute('data-price'));
        const itemQuantity = parseInt(item.querySelector('.item-quantity').textContent);
        const itemTotalPrice = itemPrice * itemQuantity;
        totalPrice += itemTotalPrice;

        detailsHtml += `
            <tr class="order-detail">
                <td class="order-detail-sno">${index + 1}</td>
                <td class="order-detail-item">${itemName}</td>
                <td class="order-detail-price">${itemTotalPrice.toFixed(2)}</td>
                <td class="order-detail-actions">
                    <div class="quantity-container">
                        <div class="quantity-heading">Number of Servings:</div>
                        <input type="number" class="quantity" value="${itemQuantity}" min="1" data-id="${item.getAttribute('data-name')}">
                        <div class="actions-container">
                            <span class="dustbin" data-id="${item.getAttribute('data-name')}">&#x1F5D1;</span>
                        </div>
                    </div>
                </td>
            </tr>
        `;
    });

    detailsHtml += `
        <tr class="order-detail total-row">
            <td colspan="2"></td>
            <td class="total-cell">Total: <br>${totalPrice.toFixed(2)}</td>
            <td></td>
        </tr>
    `;

    orderDetails.innerHTML = detailsHtml;
    modal.style.display = 'block';
    overlay.style.display = 'block';

    // Highlight the clicked table card
    tableCards.forEach(card => card.style.backgroundColor = '#f9f9f9'); // Reset all cards
    tableCard.style.backgroundColor = 'yellow'; // Highlight the clicked card

}

// Function to handle item removal and quantity updates
function handleOrderDetailClick(e) {
    const tableCardId = modal.getAttribute('data-table-id');
    const tableCard = document.querySelector(`#${tableCardId}`);

    if (e.target.classList.contains('dustbin')) {
        const itemId = e.target.getAttribute('data-id');
        const orderItem = tableCard.querySelector(`.order-item[data-name="${itemId}"]`);
        if (orderItem) {
            orderItem.remove();
            updateTableInfo(tableCard);
            showOrderDetails(tableCard); // Refresh modal
        }
    } else if (e.target.classList.contains('quantity')) {
        const itemId = e.target.getAttribute('data-id');
        const newQuantity = parseInt(e.target.value, 10);
        const orderItem = tableCard.querySelector(`.order-item[data-name="${itemId}"]`);
        if (orderItem) {
            const itemPrice = parseFloat(orderItem.getAttribute('data-price'));
            const itemTotalPrice = newQuantity * itemPrice;
            orderItem.querySelector('.item-quantity').textContent = newQuantity;

            // Update item total price in modal
            const priceCell = e.target.closest('tr').querySelector('.order-detail-price');
            priceCell.textContent = itemTotalPrice.toFixed(2);

            // Update modal total price
            let updatedTotalPrice = 0;
            const allItems = orderDetails.querySelectorAll('.order-detail:not(.total-row)');
            allItems.forEach(itemRow => {
                const itemPrice = parseFloat(itemRow.querySelector('.order-detail-price').textContent);
                updatedTotalPrice += itemPrice;
            });

            const totalRow = orderDetails.querySelector('.total-row .total-cell');
            totalRow.innerHTML = `Total: <br>${updatedTotalPrice.toFixed(2)}`;
        }
    } else if (e.target.classList.contains('increment-button')) {
        const quantityInput = e.target.previousElementSibling;
        const itemId = quantityInput.getAttribute('data-id');
        const newQuantity = parseInt(quantityInput.value, 10) + 1;
        quantityInput.value = newQuantity;

        const orderItem = tableCard.querySelector(`.order-item[data-name="${itemId}"]`);
        if (orderItem) {
            const itemPrice = parseFloat(orderItem.getAttribute('data-price'));
            const itemTotalPrice = newQuantity * itemPrice;
            orderItem.querySelector('.item-quantity').textContent = newQuantity;

            // Update item total price in modal
            const priceCell = e.target.closest('tr').querySelector('.order-detail-price');
            priceCell.textContent = itemTotalPrice.toFixed(2);

            // Update modal total price
            let updatedTotalPrice = 0;
            const allItems = orderDetails.querySelectorAll('.order-detail:not(.total-row)');
            allItems.forEach(itemRow => {
                const itemPrice = parseFloat(itemRow.querySelector('.order-detail-price').textContent);
                updatedTotalPrice += itemPrice;
            });

            const totalRow = orderDetails.querySelector('.total-row .total-cell');
            totalRow.innerHTML = `Total: <br>${updatedTotalPrice.toFixed(2)}`;
        }
    }
}

// Add event listeners to table cards
tableCards.forEach(card => {
    card.addEventListener('click', function() {
        modal.setAttribute('data-table-id', this.id); // Store the table ID in the modal
        showOrderDetails(this);
    });

    card.addEventListener('dragover', function(e) {
        e.preventDefault();
        this.style.backgroundColor = '#e9ecef'; // Highlight on dragover
    });

    card.addEventListener('dragleave', function() {
        this.style.backgroundColor = '#f9f9f9'; // Remove highlight
    });

    card.addEventListener('drop', function(e) {
        e.preventDefault();
        this.style.backgroundColor = '#f9f9f9'; // Remove highlight

        const item = document.querySelector('.dragging');
        if (item) {
            const itemName = item.getAttribute('data-name');
            const itemPrice = parseFloat(item.getAttribute('data-price'));

            let orderItem = this.querySelector(`.order-item[data-name="${itemName}"]`);
            if (orderItem) {
                const quantityElement = orderItem.querySelector('.item-quantity');
                quantityElement.textContent = parseInt(quantityElement.textContent) + 1;
            } else {
                orderItem = document.createElement('div');
                orderItem.className = 'order-item';
                orderItem.setAttribute('data-name', itemName);
                orderItem.setAttribute('data-price', itemPrice);

                orderItem.innerHTML = `
                    <span class="item-name">${itemName}</span>
                    
                    <span class="item-quantity">1</span>
                `;

                this.appendChild(orderItem);
            }

            updateTableInfo(this);
        }
    });
});

    // Implementing touch-based drag-and-drop functionality
    let touchStartX = 0;
    let touchStartY = 0;

    function handleTouchStart(e) {
        if (e.target.classList.contains('menu-item')) {
            draggedItem = e.target;
            touchStartX = e.touches[0].clientX;
            touchStartY = e.touches[0].clientY;
        }
    }

    function handleTouchMove(e) {
        if (draggedItem) {
            const touchX = e.touches[0].clientX;
            const touchY = e.touches[0].clientY;

            // Update position of dragged item based on touch movement
            draggedItem.style.position = 'absolute';
            draggedItem.style.left = `${touchX - draggedItem.offsetWidth / 2}px`;
            draggedItem.style.top = `${touchY - draggedItem.offsetHeight / 2}px`;
        }
    }

    function handleTouchEnd(e) {
        if (draggedItem) {
            const touchX = e.changedTouches[0].clientX;
            const touchY = e.changedTouches[0].clientY;

            const tableCard = Array.from(tableCards).find(card => {
                const rect = card.getBoundingClientRect();
                return touchX >= rect.left && touchX <= rect.right &&
                       touchY >= rect.top && touchY <= rect.bottom;
            });

            if (tableCard) {
                const itemName = draggedItem.querySelector('.item-name').textContent;
                const itemPrice = draggedItem.getAttribute('data-price');

                const existingOrder = tableCard.querySelector(`.order-item[data-name="${itemName}"]`);
                if (existingOrder) {
                    const quantity = existingOrder.querySelector('.item-quantity');
                    quantity.textContent = parseInt(quantity.textContent, 10) + 1;
                } else {
                    const orderItem = document.createElement('div');
                    orderItem.className = 'order-item';
                    orderItem.setAttribute('data-name', itemName);
                    orderItem.setAttribute('data-price', itemPrice);
                    orderItem.innerHTML = `
                        <span class="item-name">${itemName}</span>
                        <span class="item-quantity">1</span>
                    `;
                    tableCard.appendChild(orderItem);
                }
                updateTableInfo(tableCard);
            }

            // Reset dragged item style and state
            draggedItem.style.position = '';
            draggedItem.style.left = '';
            draggedItem.style.top = '';
            draggedItem = null;
        }
    }

    menuList.addEventListener('touchstart', handleTouchStart);
    menuList.addEventListener('touchmove', handleTouchMove);
    menuList.addEventListener('touchend', handleTouchEnd);

    tableCards.forEach(card => {
        card.addEventListener('touchstart', function(e) {
            e.preventDefault();
        });
    });


// Handle drag and drop for menu items
menuList.addEventListener('dragstart', function(e) {
    if (e.target.classList.contains('menu-item')) {
        e.target.classList.add('dragging');
    }
});

menuList.addEventListener('dragend', function(e) {
    e.target.classList.remove('dragging');
});

// Handle search input for menu and tables
searchMenuInput.addEventListener('input', function() {
    filterMenuItems(this.value);
});

searchTableInput.addEventListener('input', function() {
    filterTableItems(this.value);
});

// Clear search input functionality
clearMenuSearch.addEventListener('click', function() {
    searchMenuInput.value = '';
    filterMenuItems('');
});

clearTableSearch.addEventListener('click', function() {
    searchTableInput.value = '';
    filterTableItems('');
});

// Sort menu items
sortMenuItems();

// Close modal functionality
closeModal.addEventListener('click', function() {
    modal.style.display = 'none';
    overlay.style.display = 'none';

    tableCards.forEach(card => card.style.backgroundColor = '#f9f9f9'); // Reset all cards

});

// Handle clicks in the modal
orderDetails.addEventListener('click', handleOrderDetailClick);

// Handle clicks outside modal to close
overlay.addEventListener('click', function() {
    //modal.style.display = 'none';
    overlay.style.display = 'none';
});
document.querySelectorAll('.table-card').forEach(tableCard => {
    tableCard.addEventListener('click', () => {
        const tableNumber = tableCard.getAttribute('data-table');
        const modalTitle = document.getElementById('modalTitle');
        modalTitle.innerHTML = `Table - ${tableNumber} | Order Details`;
    });
});

    // Event listener for opening the modal
    tableCards.forEach(card => {
        let touchTimeout;
        card.addEventListener('click', () => {
            clearTimeout(touchTimeout); // Cancel any pending touch event
            showOrderDetails(card);
        });

        card.addEventListener('touchend', (e) => {
            e.preventDefault();
            touchTimeout = setTimeout(() => {
                showOrderDetails(card);
            }, 150); // Delay to prevent click event from firing immediately
        });
    });
// Handle "CLOSE SESSION (GENERATE BILL)" button click
closeSessionBtn.addEventListener('click', function() {
    // Get the table card ID from the modal
    const tableCardId = modal.getAttribute('data-table-id');
    const tableCard = document.querySelector(`#${tableCardId}`);

    // Check if the table has any items
    const items = tableCard.querySelectorAll('.order-item');
    if (items.length === 0) {
        // Alert if no items are present in the table
        alert('Please select items for the table to generate the bill');
        // Close the modal after the alert is dismissed
        setTimeout(() => {
            modal.style.display = 'none';
            overlay.style.display = 'none';
            tableCards.forEach(card => card.style.backgroundColor = '#f9f9f9'); // Reset all cards
        }, 0); // 0 ms delay for immediate execution after the alert
        return; // Exit the function if no items are present    
    }

    // Calculate the total amount from the modal
    const totalRow = orderDetails.querySelector('.total-row .total-cell');
    const totalAmount = totalRow.textContent.split(':')[1].trim();

    // Show the thank-you pop-up
    alert(`Total Amount: ${totalAmount}\nThanks for ordering!`);

    // Reset the table's order details
    if (tableCard) {
        items.forEach(item => item.remove()); // Remove all order items
        updateTableInfo(tableCard); // Update table info to reflect the reset
    }

    // Close the modal and overlay
    modal.style.display = 'none';
    overlay.style.display = 'none';
    
    // Reset all table cards' background color
    tableCards.forEach(card => card.style.backgroundColor = '#f9f9f9');
});
});