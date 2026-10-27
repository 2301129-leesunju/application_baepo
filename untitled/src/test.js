let subject = prompt("신청 과목 선택. 숫자만 입력");

if (subject!==null) {
    switch (subject) {
        case "1": {
            document.write("HTML 신청");
        }
            break;
        case "2": {
            document.write("CSS 신청");
        }
        break;
        case "3": {
            document.write("Javascript");
        }
        break;
        default:document.write("잘못 입력");
    }
}

let coupon = parseInt(prompt("쿠폰 개수 입격 (0 ~ 29)"))
if (isNaN(coupon) || coupon < 0 || coupon > 29) {
    document.write("0 ~ 29 사이 숫자를 입력하시오.");

} else {
    let gift;
    switch (Math.floor(coupon / 10)) {
        case 2:
            gift = "여행가방";
            break;
        case 1:
            gift = "다이어리";
            break;
        default:
            gift = "커피 한잔";

    }
    document.write(
        "쿠폰 : " + coupon + "장<br>"
    );

    document.write(
        "사은품 : " + gift
    );


}


