document.addEventListener('DOMContentLoaded', function() {
    const menuList = document.getElementById('menuList');
    // Function to create and display menu items
    function createMenu() {
        for (const item in menu) {
            const menuItemLi = document.createElement('li');
            menuItemLi.className = 'menu-item';
            menuItemLi.dataset.category = menu[item].category.toLowerCase().replace(/\s+/g, '-');
            menuItemLi.draggable = true;
            menuItemLi.dataset.name = menu[item].name;
            menuItemLi.dataset.price = menu[item].cost;
            menuItemLi.innerHTML = `
                <span class="item-name">${menu[item].name}</span>
                <span class="item-category">(${menu[item].category})</span>
                <span class="item-price">Rs. ${menu[item].cost.toFixed(2)}</span>
            `;
            menuList.appendChild(menuItemLi);
        }
    }
    // Call the function to create menu items
    createMenu();
});


