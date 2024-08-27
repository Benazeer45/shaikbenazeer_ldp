document.addEventListener('DOMContentLoaded', function() {
    const searchMenuInput = document.getElementById('searchMenu');
    const clearMenuSearch = document.getElementById('clearMenuSearch');
    // Prevent drag-and-drop in the search menu input
    searchMenuInput.addEventListener('dragover', function(event) {
        event.preventDefault();
    });
    searchMenuInput.addEventListener('drop', function(event) {
        event.preventDefault();
    });
    // Function to filter menu items based on search input
    function filterMenu(query) {
        query = query.toLowerCase();
        const menuItems = document.querySelectorAll('#menuList .menu-item'); // Select dynamically created menu items
        let hasResults = false;
        menuItems.forEach(item => {
            const itemName = item.querySelector('.item-name').textContent.toLowerCase();
            const itemCategory = item.querySelector('.item-category').textContent.toLowerCase();
            if (itemName.includes(query) || itemCategory.includes(query)) {
                item.style.display = '';
                hasResults = true;
            } else {
                item.style.display = 'none';
            }
        });
        // Show "No results found" message if no items match
        let noResultsMessage = document.getElementById('menuNoResultsMessage');
        if (!noResultsMessage) {
            noResultsMessage = document.createElement('div');
            noResultsMessage.id = 'menuNoResultsMessage';
            noResultsMessage.textContent = 'No results found';
            document.getElementById('menuList').appendChild(noResultsMessage);
        }
        noResultsMessage.style.display = hasResults ? 'none' : 'block';
    }
    // Event listener for search input
    searchMenuInput.addEventListener('input', function() {
        filterMenu(this.value);
    });
    // Event listener for clear search button
    clearMenuSearch.addEventListener('click', function() {
        searchMenuInput.value = '';
        filterMenu('');
    });
});