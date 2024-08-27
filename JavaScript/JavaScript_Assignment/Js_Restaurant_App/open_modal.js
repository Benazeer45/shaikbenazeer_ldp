document.addEventListener('DOMContentLoaded', function() {
    const orderModal = document.getElementById('orderModal');
    const closeModalButton = orderModal.querySelector('.close');
    // Variable to store the currently highlighted table
    let highlightedTableId = null;
    // Function to open the modal
    function openModal(tableId) {
        // Check if tableId is provided
        if (!tableId) {
            console.error('No tableId provided to openModal');
            return;
        }
        const tableElement = document.getElementById(tableId);
        // Clear any previous highlights
        document.querySelectorAll('#tables .table-card').forEach(card => {
            card.style.backgroundColor = ''; // Reset background color
        });
        // Highlight the selected table
        if (tableElement) {
            tableElement.style.backgroundColor = 'yellow';
            highlightedTableId = tableId; // Store the highlighted table ID
        } else {
            console.error(`Table with ID ${tableId} not found`);
        }
        // Show the modal
        orderModal.style.display = 'block';
    }
    // Function to close the modal
    function closeModal() {
        // Reset the background color of the highlighted table
        if (highlightedTableId) {
            const highlightedTable = document.getElementById(highlightedTableId);
            if (highlightedTable) {
                highlightedTable.style.backgroundColor = ''; // Reset background color
            }
            highlightedTableId = null; // Clear the stored table ID
        }
        // Hide the modal
        orderModal.style.display = 'none';
    }
    // Event listener to close the modal when clicking the close button
    closeModalButton.addEventListener('click', closeModal);
    // Event listener for table cards
    document.querySelectorAll('#tables .table-card').forEach(card => {
        card.addEventListener('click', function() {
            openModal(card.id); // Pass the table id to openModal
        });
    });
    // Initial state
    orderModal.style.display = 'none';
});
