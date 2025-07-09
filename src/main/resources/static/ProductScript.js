$(document).ready(function () {


    // Rather than handling submission of the update form with product ID,
    // deal with this specific product update API call from this JS function
    $('#updateModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var id = button.data('id');

        // Set the action dynamically based on the product ID
        $('#updateProductForm').attr('action', '/products/updateByID/' + id);

        var description = button.data('description');
        var category = button.data('category');
        var price = button.data('price');

        // Populate the form fields with the data
        $('#updateProductId').val(id);
        $('#updateDescription').val(description);
        $('#updateCategory').val(category);
        $('#updatePrice').val(price);
    });

    // Ensure that the form is submitted using the updateProduct function
    $('#updateProductForm').submit(function (event) {
        updateProduct(event);
    });
});


let counter = 1;

function filterProducts() {
    // Get selected category from the dropdown
    var selectedCategory = document.getElementById('filterCategory').value.toLowerCase();

    // Get input value and convert to lowercase for case-insensitive search
    var searchInput = document.getElementById('productSearchInput').value.toLowerCase();

    var table = document.getElementById('productTable');
    var rows = table.getElementsByTagName('tr');

    // Loop through all rows and apply filters
    for (var i = 0; i < rows.length; i++) {
        var tdCategory = rows[i].getElementsByTagName('td')[3]; // Assuming category is in the fourth column

        if (tdCategory) {
            var category = tdCategory.textContent.toLowerCase();

            // Check if the row matches the selected category and search input
            var matchesCategory = selectedCategory === '' || category === selectedCategory;
            var matchesSearch = searchInput === '' || rows[i].textContent.toLowerCase().includes(searchInput);

            // Show or hide the row based on the filter criteria
            if (matchesCategory && matchesSearch) {
                rows[i].style.display = '';
            } else {
                rows[i].style.display = 'none';
            }
        }
    }
}

// Call the filterProducts function when the page loads
document.addEventListener('DOMContentLoaded', function () {
    filterProducts();
});
