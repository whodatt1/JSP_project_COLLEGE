
window.addEventListener('DOMContentLoaded', () => {
    printReviewList(document.querySelector('#delForm input[name=sno]').value);
    const sno = document.querySelector('input[name=sno]').value;
});

const grade = document.querySelector('input[name=grade]').value;
if (Number(grade) > 49) {
    document.getElementById('delBtn').addEventListener('click', () => {
        const delForm = document.getElementById('delForm');
        delForm.submit();
    });
}
async function postReviewToServer(rvData) {
    try {
        const url = "/reviCtrl/register";
        const config = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(rvData)
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
};
if (Number(grade) < 49) {
document.getElementById('rvPostBtn').addEventListener('click', () => {
    const rvContent = document.getElementById('rvContent').value;
    const rvScore = document.getElementById('rvScore').value;
    const rvTitle = document.getElementById('rvTitle').value;
    if (rvContent == null || rvContent == '') {
        alert('댓글 내용을 입력해 주세요!');
        return false;
    } else if (rvScore == null || rvScore == '') {
        alert('리뷰 점수를 선택해 주세요');
        return false;
    } else if (rvTitle == null || rvTitle == '') {
        alert('리뷰 제목을 입력해 주세요');
    } else {
        let rvData = {
            sno : document.querySelector('#delForm input[name=sno]').value,
            title : rvTitle,
            id : document.querySelector('input[name=email]').value,
            writer : document.getElementById('rvWriter').innerText,
            score : rvScore,
            content : rvContent
        };
        postReviewToServer(rvData).then(result => {
            printReviewList(rvData.sno);
        });
    }
});
}
async function spreadReviewFromServer(sno) {
    try {
        const resp = await fetch('/reviCtrl/list/'+sno);
        const rvList = await resp.json();
        return await rvList;
    } catch (error) {
        console.log(error);
    }
}

function printReviewList(sno) {
    spreadReviewFromServer(sno).then(result => {
        const email = document.querySelector('input[name=email]').value;
        const grade = document.querySelector('input[name=grade]').value;
        if(result.length > 0) {
            let ul = document.getElementById('rvListArea');
            ul.innerHTML = '';
            let score = 0;
            for (const rvvo of result) {
                let liIn =`<li data-rvno="${rvvo.rvno}" class="rvTarget"><div class="mar-btm">`;
                liIn +=`<input type="hidden" name="divInId" value="${rvvo.id}">`
                liIn +=`<h4 class="text-semibold media-heading box-inline">${rvvo.writer}</h4>`
                liIn +=`<p class="text-muted text-sm">${rvvo.modAt}<span style='float:right'><span class="rvScore">${rvvo.score}</span> / 5 <i class="far fa-star"></i></span></p></div>`
                liIn +=`<p class="rvTitle">${rvvo.title}</p>`
                liIn +=`<p class="rvContent">${rvvo.content}</p>`
                liIn +=`<div class="pad-ver text-right">`
                liIn +=`<div class="btn-group">`
                if (email === rvvo.id || grade === '101') {
                    liIn +=`<button type="button" class="btn mod" data-toggle="modal" data-target="#exampleModal" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">수정</button>`
                    liIn +=`<button type="button" class="btn del" style="border-radius: 25% 10%; color:white; background : #C2C4B6;">삭제</button>`
                }
                liIn +=`</div></div></li><hr>`
                ul.innerHTML += liIn;
                score += Number(`${rvvo.score}`);
            }
            let rvAvg = score / result.length;
            document.getElementById('rvAvg').innerText = rvAvg.toFixed(1);
        } else {
            document.getElementById('rvListArea').innerHTML = '';
            console.log('Comment List is empty');
        }
    });
}

async function eraseReviewFromServer(rvno) {
    try {
        const url = '/reviCtrl/remove/'+rvno;
        const config = {
            method: 'post'
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

document.addEventListener('click', (e) => {
    if(e.target.classList.contains('del')) {
        let li = e.target.closest('li');
        let rvno = li.dataset.rvno;
        eraseReviewFromServer(rvno).then(result => {
            printReviewList(document.querySelector('#delForm input[name=sno]').value);
        });
    } else if (e.target.classList.contains('mod')) {
        let li = e.target.closest('li');
        let rvno = li.dataset.rvno;
        let score = li.querySelector('.rvScore').innerText;
        let optionList = document.querySelectorAll('#rvScoreMod option');
        console.log(optionList);
        document.getElementById('rvTitleMod').value = li.querySelector('.rvTitle').innerText;
        document.getElementById('rvContentMod').value = li.querySelector('.rvContent').innerText;
        optionList.forEach(option => {
            if(score === option.value) {
                option.setAttribute('selected', true);
            }
        })
        document.getElementById('rvTitleMod').dataset.rvno = rvno;
    }
});

async function modifyReviewToServer(rvData) {
    try {
        const url = '/reviCtrl/update';
        const config = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(rvData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

document.getElementById('rvModBtn').addEventListener('click', () => {
    let rvData = {
        rvno: document.getElementById('rvTitleMod').dataset.rvno,
        title: document.getElementById('rvTitleMod').value,
        score: document.getElementById('rvScoreMod').value,
        content: document.getElementById('rvContentMod').value
    }
    // console.log(rvData);
    modifyReviewToServer(rvData).then(result => {
        document.querySelector('#rvCloseBtn').click();
        printReviewList(document.querySelector('#delForm input[name=sno]').value);
    })

});

