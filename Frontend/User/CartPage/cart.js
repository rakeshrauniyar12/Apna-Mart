async function viewProducts() {
    let res = await fetch("https://sweltering-ladybug-production.up.railway.app/getallproduct");
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
      let img = document.createElement("img");
      img.src = el.imageUrl;
      let h2 = document.createElement("p");
      h2.innerText = el.name;
      let p2 = document.createElement("p");
      p2.innerText = el.price;
      let btn1 = document.createElement("button");
      btn1.innerText = "Edit";
      btn1.style = "padding:10px 20px;text-align:centre;";
      let btn2 = document.createElement("button");
      btn2.innerText = "Delete";
      btn2.addEventListener("click", () => {
        delete1(el.productId);
      });
      div.append(img, h2, p2, btn1, btn2);
      cont.append(div);
    });
  };
  async function delete1(id) {
    let res = await fetch(`https://sweltering-ladybug-production.up.railway.app/deleteproducts/${id}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    });
    res = await res.json();
    viewProducts(res);
  }