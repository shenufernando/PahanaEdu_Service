// auth.js

// ===== REGISTER FUNCTION =====
function registerCustomer(event) {
  event.preventDefault();

  const accountNo = document.querySelector('input[name="accountNo"]').value.trim();
  const name = document.querySelector('input[name="name"]').value.trim();
  const address = document.querySelector('input[name="address"]').value.trim();
  const phone = document.querySelector('input[name="phone"]').value.trim();
  const units = document.querySelector('input[name="units"]').value.trim();
  const role = document.querySelector('select[name="role"]').value;
  const password = prompt("Set a password for this account:"); // ask password

  if (!accountNo || !name || !address || !phone || !units || !role || !password) {
    alert("Please fill in all fields.");
    return;
  }

  const user = {
    accountNo,
    name,
    address,
    phone,
    units,
    role,
    password
  };

  // Save user to localStorage
  localStorage.setItem("registeredUser", JSON.stringify(user));
  alert("Customer registered successfully!");

  // Redirect to login
  window.location.href = "login.html";
}

// ===== LOGIN FUNCTION =====
function loginUser(event) {
  event.preventDefault();

  const username = document.getElementById("username").value.trim();
  const password = document.getElementById("password").value;

  const savedUser = JSON.parse(localStorage.getItem("registeredUser"));

  if (!savedUser) {
    alert("No user registered yet!");
    return;
  }

  if (savedUser.name === username && savedUser.password === password) {
    alert("Login successful!");

    if (savedUser.role === "admin") {
      window.location.href = "admin_dashboard.html";
    } else if (savedUser.role === "cashier") {
      window.location.href = "cashier_dashboard.html";
    } else {
      alert("Unknown role.");
    }
  } else {
    alert("Invalid username or password.");
  }
}

