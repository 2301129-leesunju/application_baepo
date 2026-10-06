function toggleSystem() {
    const status=document.getElementById("status");
    const button=document.getElementById("systemButton");
    const message=document.getElementById("message");
    const isOnline=status.classList.toggle("on");
    if (isOnline) {
        status.textContent="ONLINE";
        button.textContent="SYSTEM STOP";
        message.textContent="시스템이 활성화되었습니다.";
    }else {
        status.textContent="OFFLINE";
        button.textContent="SYSTEM START";
        message.textContent="미래의 IT 기기를 탐색하는 웹서비스";
    }
}
const products=[
    {name:"AI LAPTOP", type:"COMPUTING"},
    {name:"SMART GLASS", type:"WEARABLE"},
    {name:"ROBOT KIT", type:"ROBOTICS"}
];
function loadCatalog() {
    const catalog=document.getElementById("catalog");
    catalog.replaceChildren();
    for (const product of products) {
        const card=document.createElement("article");
        card.className="product-card";
        const type=document.createElement("span");
        type.className="product-type";
        type.textContent=product.type;

        const title=document.createElement("h3");
        title.textContent=product.name;
        card.appendChild(type);
        card.appendChild(title);
        catalog.appendChild(card);
    }
}
function clearCatalog() {
    const catalog=document.createElement("catalog");
    catalog.innerHTML= '<p class="empty-message">'+'아직 생성된 상품이 없습니다,'+'</p>';
}

document.getElementById("systemButton").addEventListener("click", toggleSystem);
document.getElementById("loadButton").addEventListener("click", loadCatalog);
document.getElementById("clearButton").addEventListener("click", clearCatalog);

/*검증 JS*/
const productForm = document.getElementById("productForm");

productForm.addEventListener("submit", function(event) {

    event.preventDefault();

    const name = document.getElementById("productName").value.trim();

    if (name.length < 2) {

        document.getElementById("validationMessage").textContent =
            "상품명은 2글자 이상";

        document.getElementById("previewCard").classList.add("hidden");

        return;
    }

    const price = Number(
        document.getElementById("productPrice").value
    );

    document.getElementById("previewName").textContent = name;

    document.getElementById("previewPrice").textContent =
        price.toLocaleString() + "원";

    document.getElementById("previewCard").classList.remove("hidden");

    document.getElementById("validationMessage").textContent =
        "웹검증을 통과";

});