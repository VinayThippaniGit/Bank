document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("reset-password-form");
    const newPassword = document.getElementById("new_password");
    const confirmPassword = document.getElementById("confirm_password");
    const errorMessage = document.getElementById("error-message");

    form.addEventListener("submit", function(event) {
        if (newPassword.value !== confirmPassword.value) {
            event.preventDefault(); // Prevent form submission
            errorMessage.textContent = "New Password and Confirm New Password do not match.";
            errorMessage.style.color = "red";
        } else {
            errorMessage.textContent = ""; // Clear any previous error message
        }
    });
});
