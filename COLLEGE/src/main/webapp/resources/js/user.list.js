window.addEventListener('DOMContentLoaded', () => {
    printUserList();
});

async function modifyUserToServer(usData) {
    try {
        const url = '/userCtrlJs/modify'
        const config = {
            method: 'post',
            headers: {
                'Content-Type': 'application/json; charser=utf-8'
            },
            body: JSON.stringify(usData)
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

document.addEventListener('click', (e) => {
    if(e.target.classList.contains('mod')) {
        const tr = e.target.closest('tr');
        const email = tr.querySelector('#email').innerText;
        const grade = tr.querySelector('#grade > option:checked').value;

        const usData = {
            email: email,
            grade: grade
        }

        modifyUserToServer(usData).then(result => {
            if (result > 0) {
                
                alert('수정이 완료되었습니다');
                printUserList();
            }
        })
    }
})

async function spreadUserFromServer() {
    try {
        const resp = await fetch('/userCtrlJs/list');
        const usList = await resp.json();
        return await usList;
    } catch (error) {
        console.log(error);
    }
}

function printUserList() {
    spreadUserFromServer().then(result => {
        if (result.length > 0) {
            const tbody = document.getElementById('userList');
            tbody.innerHTML = '';
            for (const uvo of result) {
                console.log(typeof `${uvo.grade}`);
                let tbodyIn = `<tr>`
                tbodyIn += `<td id="email">`
                tbodyIn += `${uvo.email }`
                tbodyIn += `</td>`
                tbodyIn += `<td>${uvo.userName }</td>`
                tbodyIn += `<td>${uvo.regAt }</td>`
                tbodyIn += `<td>${uvo.lastLogin }</td>`
                tbodyIn += `<td>${uvo.major }</td>`
                tbodyIn += `<td>`
                tbodyIn += `<select style="width:70px;" id="grade">`
        		if (`${uvo.grade}` === '101') {
                    tbodyIn += `<option value="101" selected>관리자</option>`
                } else if (`${uvo.grade}` === '50') {
                    tbodyIn += `<option value="50" selected>교수</option>`
                    tbodyIn += `<option value="10">학생</option>`
                } else if (`${uvo.grade}` === '10') {
                    tbodyIn += `<option value="50">교수</option>`
                    tbodyIn += `<option value="10" selected>학생</option>`
                }
                tbodyIn += `</select>`
        	    tbodyIn += `&nbsp;<button type="submit" class="btn mod" style="border-radius: 25% 10%; color:white; background : #F7F0C6;">조정</button>`
                tbodyIn += `</td></tr>`

                tbody.innerHTML += tbodyIn;
            }
        } else {
            console.log('User List is empty')
        }

    })
}