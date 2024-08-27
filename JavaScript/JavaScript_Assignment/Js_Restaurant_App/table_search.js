document.addEventListener('DOMContentLoaded', function() {
    const searchTableInput = document.getElementById('searchTable');
    const clearTableSearch = document.getElementById('clearTableSearch');
    // Prevent drag-and-drop in the search table input
    searchTableInput.addEventListener('dragover', function(event) {
        event.preventDefault();
    });
    searchTableInput.addEventListener('drop', function(event) {
        event.preventDefault();
    });
    // Function to filter tables based on search input
    function filterTables(query) {
        query = query.toLowerCase();
        const tables = document.querySelectorAll('#tables .table-card');
        let hasResults = false;
        tables.forEach(table => {
            const tableName = table.querySelector('h3').textContent.toLowerCase();
            if (tableName.includes(query)) {
                table.style.display = '';
                hasResults = true;
            } else {
                table.style.display = 'none';
            }
        });
        // Show "No results found" message if no tables match
        let noResultsMessage = document.getElementById('tableNoResultsMessage');
        if (!noResultsMessage) {
            noResultsMessage = document.createElement('div');
            noResultsMessage.id = 'tableNoResultsMessage';
            noResultsMessage.textContent = 'No results found';
            document.getElementById('tables').appendChild(noResultsMessage);
        }
        noResultsMessage.style.display = hasResults ? 'none' : 'block';
    }
    // Event listener for search input
    searchTableInput.addEventListener('input', function() {
        filterTables(this.value);
    });
    // Event listener for clear search button
    clearTableSearch.addEventListener('click', function() {
        searchTableInput.value = '';
        filterTables('');
    });
});