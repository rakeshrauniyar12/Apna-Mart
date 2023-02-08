document.querySelector("#submit").addEventListener("click", () => {
  registerUser();
});
let registerUser = async () => {
  let adminName = document.querySelector("#name").value;
  let adminEmail = document.querySelector("#email").value;
  let adminPassword = document.querySelector("#password").value;
  let mobileNo = document.querySelector("#mobile").value;
  let userData = {
    adminName,
    adminEmail,
    adminPassword,
    mobileNo,
  };
  console.log(userData);
  let res = await fetch("http://localhost:8090/admin/saveadmindetails", {
    method: "POST",
    body: JSON.stringify(userData),
    headers: {
      "Content-Type": "application/json",
    },
  });
  res = await res.json();
  if (res.message === "Password should be between 8 to 20") {
    alert("Password should be between 8 to 20");
  } else if (res.message === "Name should not be null") {
    alert("name should not be null");
  }
  console.log(res);
  document.querySelector("#name").value = "";
  document.querySelector("#email").value = "";
  document.querySelector("#password").value = "";
  document.querySelector("#mobile").value = "";
};
