async function viewProducts() {
  let uid = JSON.parse(localStorage.getItem("user_id"));
  let res = await fetch(
    `https://sweltering-ladybug-production.up.railway.app/getallproduct/${uid}`
  );
  res = await res.json();
  renderDom(res);
}
viewProducts();
let renderDom = (data) => {
  let cont = document.querySelector("#cont");
  cont.innerHTML = "";
  data.forEach((el) => {
    let maindiv=document.createElement("div");
    maindiv.setAttribute("id","mainDiv")
    let div = document.createElement("div");
    let div2= document.createElement("div");
    let div3 = document.createElement("div");
    let img = document.createElement("img");
    img.src = el.imageUrl;
    let h2 = document.createElement("p");
    h2.innerText = `Name:- ${el.name}`;
    let p2 = document.createElement("p");
    p2.innerText = `Price:- ${el.price}`;
    let btn1 = document.createElement("button");
    btn1.innerText = "Edit";
   btn1.setAttribute("class","cart-btn")
    let btn2 = document.createElement("button");
    btn2.innerText = "Delete";
    btn2.addEventListener("click", () => {
      delete1(el);
    });
    btn2.style="background-color:red;"
    btn2.setAttribute("class","cart-btn")
    div.append(img);
    div2.append(h2,p2);
    div3.append(btn1,btn2);
    maindiv.append(div,div2,div3)
    cont.append(maindiv);
  });
};
async function delete1(el) {
  let uid = JSON.parse(localStorage.getItem("user_id"));
  
 
  let res = await fetch(
    `https://sweltering-ladybug-production.up.railway.app/deleteproduct/${uid}/${el.productId}`,
    {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    }
  );
  let data = await res.json();
  viewProducts();
}
