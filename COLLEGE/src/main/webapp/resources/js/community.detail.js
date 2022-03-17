window.addEventListener('DOMContentLoaded', () => {
    printReplyList(document.querySelector('#delForm input[name=cno]').value);
});

const email = document.querySelector('input[name=email]').value;
const writerId = document.getElementById('rpId').value;
const grade = document.querySelector('input[name=grade]').value;
if (email == writerId || grade === '101') {
    document.getElementById('delBtn').addEventListener('click', () => {
        const delForm = document.getElementById('delForm');
        delForm.submit();
    });
}

async function postReplyToServer(rpData) {
    try {
        const url = '/replCtrl/register';
        const config = {
            method: 'post',
            header: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(rpData)
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

document.getElementById('rpPostBtn').addEventListener('click', () => {
    const rpId = document.querySelector('input[name=email]').value;
    const rpContent = document.getElementById('rpContent').value;
    const cno = document.querySelector('input[name=cno]').value;
    console.log(rpId);
    if (rpContent == null || rpContent == '') {
        alert('댓글 내용을 입력해주세요');
    }

    let rpData = {
        cno: cno,
        id: rpId == '' || rpId == null ? 'Anonymous' : rpId,
        replier: document.getElementById('rpWriter').innerText == null || document.getElementById('rpWriter').innerText == '' ? 'Anonymous' : document.getElementById('rpWriter').innerText,
        content: rpContent
    }

    postReplyToServer(rpData).then(result => {
        document.getElementById('rpContent').value = '';
        printReplyList(rpData.cno);
    })
});

async function spreadReplyFromServer(cno) {
    try {
        const resp = await fetch('/replCtrl/list/' + cno);
        const rpList = await resp.json();
        return await rpList;
    } catch (error) {
        console.log(error);
    }
}

function printReplyList(cno) {
    spreadReplyFromServer(cno).then(result => {
        const email = document.querySelector('input[name=email]').value;
        const grade = document.querySelector('input[name=grade]').value;
        if(result.length > 0) {
            let ul = document.getElementById('rpListArea');
            ul.innerHTML = '';
            for (const rpvo of result) {
                let liIn =`<li data-rpno="${rpvo.rpno}" class="rvTarget"><div class="mar-btm">`;
                liIn +=`<input type="hidden" name="divInId" value="${rpvo.id}">`
                liIn +=`<h4 class="text-semibold media-heading box-inline rpWriter">${rpvo.replier}</h4>`
                liIn +=`<p class="text-muted text-sm">${rpvo.modAt}</p></div>`
                liIn +=`<p class="rpContent">${rpvo.content}</p>`
                liIn +=`<div class="pad-ver text-right">`
                liIn +=`<div class="btn-group">`
                if (email === rpvo.id || grade === '101') {
                    liIn +=`<button type="button" class="btn mod" data-toggle="modal" data-target="#exampleModal" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">수정</button>`
                    liIn +=`<button type="button" class="btn del" style="border-radius: 25% 10%; color:white; background : #C2C4B6;">삭제</button>`
                }
                liIn +=`</div></div></li><hr>`
                ul.innerHTML += liIn;
            }
        } else {
            document.getElementById('rpListArea').innerHTML = '';
            console.log('Comment List is empty');
        }
    })
}

async function eraseReplyFromServer(rpno) {
    try {
        const url = '/replCtrl/remove/'+rpno;
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
    if (e.target.classList.contains('del')) {
        let li = e.target.closest('li');
        let rpno = li.dataset.rpno;
        eraseReplyFromServer(rpno).then(result => {
            printReplyList(document.querySelector('#delForm input[name=cno]').value);
        });
    } else if (e.target.classList.contains('mod')) {
        let li = e.target.closest('li');
        let rpno = li.dataset.rpno;
        document.querySelector('.modal-title').innerText = li.querySelector('.rpWriter').innerText;
        document.querySelector('#rpContentMod').value = li.querySelector('.rpContent').innerText;
        document.querySelector('#rpContentMod').dataset.rpno = rpno;
    }
})

async function modifyReplyToServer(rpData) {
    try {
        const url = '/replCtrl/update';
        const config = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(rpData)
        }
        const resp = await fetch(url, config);
        const result = resp.text()
        return result;
    } catch (error) {
        console.log(error);
    }
}

document.getElementById('rpModBtn').addEventListener('click', () => {
    let rpData = {
        rpno: document.getElementById('rpContentMod').dataset.rpno,
        content: document.getElementById('rpContentMod').value
    }
    modifyReplyToServer(rpData).then(result => {
        document.querySelector('#rpCloseBtn').click();
        printReplyList(document.querySelector('#delForm input[name=cno]').value);
    })

})