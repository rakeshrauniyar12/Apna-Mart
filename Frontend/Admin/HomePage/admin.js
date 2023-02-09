async function viewProducts() {
  let res = await fetch("http://localhost:8090/getallproduct");
  res = await res.json();
  renderDom(res);
}
viewProducts();
let renderDom = (data) => {
  let cont = document.querySelector("#cont");
  cont.innerHTML = "";
  data.forEach((el) => {
    let div = document.createElement("div");
    div.style = "display:flex;";
    let p1 = document.createElement("p");
    p1.innerText = el.productId;
    let img = document.createElement("img");
    img.src = el.imageUrl;
    let h2 = document.createElement("p");
    h2.innerText = el.name;
    let p2 = document.createElement("p");
    p2.innerText = el.price;
    let p3 = document.createElement("p");
    p3.innerText = el.quantity;
    let p4 = document.createElement("p");
    p4.innerText = el.category;
    let btn1 = document.createElement("button");
    btn1.innerText = "Edit";
    btn1.style = "padding:10px 20px;text-align:centre;";
    let btn2 = document.createElement("button");
    btn2.innerText = "Delete";
    btn2.addEventListener("click", () => {
      delete1(el.productId);
    });
    div.append(p1, img, h2, p2, p3, p4, btn1, btn2);
    cont.append(div);
  });
};
async function delete1(id) {
  let res = await fetch(`http://localhost:8090/deleteproducts/${id}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  });
  res = await res.json();
  viewProducts(res);
}
function aboutProducts() {
  let cont = document.querySelector("#mainsec");
  cont.innerHTML = "";
  let div1 = document.createElement("div");
  div1.setAttribute("id", "btn");
  let btn1 = document.createElement("button");
  btn1.innerText = "View All Product";
  btn1.style = "cursor:pointer;";
  btn1.addEventListener("click", () => {
    viewProducts();
  });
  let btn2 = document.createElement("button");
  btn2.innerText = "+ New Product";
  btn2.style = "cursor:pointer;";
  btn2.addEventListener("click", () => {
    window.location.href = "../products.html";
  });
  div1.append(btn1, btn2);
  let div2 = document.createElement("div");
  div2.setAttribute("id", "nameConvention");
  let btn3 = document.createElement("button");
  btn3.innerText = "Product ID";
  let btn4 = document.createElement("button");
  btn4.innerText = "Image";
  let btn5 = document.createElement("button");
  btn5.innerText = "Name";
  let btn6 = document.createElement("button");
  btn6.innerText = "Price";
  let btn7 = document.createElement("button");
  btn7.innerText = "Quantity";
  let btn8 = document.createElement("button");
  btn8.innerText = "Category";
  let btn9 = document.createElement("button");
  btn9.innerText = "Update";
  let btn10 = document.createElement("button");
  btn10.innerText = "Delete";
  div2.append(btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10);
  let div3 = document.createElement("div");
  div3.setAttribute("id", "cont");
  cont.append(div1, div2, div3);
}
aboutProducts();
