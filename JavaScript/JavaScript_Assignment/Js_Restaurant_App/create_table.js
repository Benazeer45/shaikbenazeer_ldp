document.addEventListener('DOMContentLoaded', function() {
    // Function to create and display tables
    function createTables() {
        const tablesSection = document.getElementById('tables');
        for (const table in tables) {
            const tableDiv = document.createElement('div');
            tableDiv.className = 'table-card';
            tableDiv.id = table;
            tableDiv.dataset.table = table.replace('table', ''); // For data-table attribute
            tableDiv.innerHTML = `
                <h3>${table.replace('table', 'Table ')}</h3>
                <div class="table-info">
                    Rs. ${tables[table].cost.toFixed(2)} | Total items: ${tables[table].items}
                </div>
            `;
            tablesSection.appendChild(tableDiv);
        }
        // Add event listeners to table cards
        document.querySelectorAll('#tables .table-card').forEach(card => {
            card.addEventListener('click', function() {
                openModal(card.id);
            });
        });
    }
    // Call the function to create tables
    createTables();
});
