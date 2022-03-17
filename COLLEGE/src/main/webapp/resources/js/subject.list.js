

document.querySelector('.all').addEventListener('click', () => {
        let human = document.querySelectorAll('.human');
        let social = document.querySelectorAll('.social');
        let edu = document.querySelectorAll('.edu');
        let engine = document.querySelectorAll('.engine');
        let nature = document.querySelectorAll('.nature');
        let medi = document.querySelectorAll('.medi');
        let art = document.querySelectorAll('.art');
        let arr = [human, social, edu, engine, nature, medi, art];
        arr.forEach(elems => {
            elems.forEach(elem => {
                elem.style.display = 'block';
            })
        });
})

document.querySelector('.hu').addEventListener('click', () => {
        let human = document.querySelectorAll('.human');
        let social = document.querySelectorAll('.social');
        let edu = document.querySelectorAll('.edu');
        let engine = document.querySelectorAll('.engine');
        let nature = document.querySelectorAll('.nature');
        let medi = document.querySelectorAll('.medi');
        let art = document.querySelectorAll('.art');
        let arr = [social, edu, engine, nature, medi, art];
        human.forEach(elem => {
            elem.style.display = 'block';
        })
        arr.forEach(elems => {
            elems.forEach(elem => {
                elem.style.display = 'none';
            })
        })
})

document.querySelector('.so').addEventListener('click', () => {
    let human = document.querySelectorAll('.human');
    let social = document.querySelectorAll('.social');
    let edu = document.querySelectorAll('.edu');
    let engine = document.querySelectorAll('.engine');
    let nature = document.querySelectorAll('.nature');
    let medi = document.querySelectorAll('.medi');
    let art = document.querySelectorAll('.art');
    let arr = [human , edu, engine, nature, medi, art];
    social.forEach(elem => {
        elem.style.display = 'block';
    })
    arr.forEach(elems => {
        elems.forEach(elem => {
            elem.style.display = 'none';
        })
    })
})

document.querySelector('.ed').addEventListener('click', () => {
    let human = document.querySelectorAll('.human');
    let social = document.querySelectorAll('.social');
    let edu = document.querySelectorAll('.edu');
    let engine = document.querySelectorAll('.engine');
    let nature = document.querySelectorAll('.nature');
    let medi = document.querySelectorAll('.medi');
    let art = document.querySelectorAll('.art');
    let arr = [human, social, engine, nature, medi, art];
    edu.forEach(elem => {
        elem.style.display = 'block';
    })
    arr.forEach(elems => {
        elems.forEach(elem => {
            elem.style.display = 'none';
        })
    })
})

document.querySelector('.en').addEventListener('click', () => {
    let human = document.querySelectorAll('.human');
    let social = document.querySelectorAll('.social');
    let edu = document.querySelectorAll('.edu');
    let engine = document.querySelectorAll('.engine');
    let nature = document.querySelectorAll('.nature');
    let medi = document.querySelectorAll('.medi');
    let art = document.querySelectorAll('.art');
    let arr = [human, social, edu, nature, medi, art];
    engine.forEach(elem => {
        elem.style.display = 'block';
    })
    arr.forEach(elems => {
        elems.forEach(elem => {
            elem.style.display = 'none';
        })
    })
})

document.querySelector('.na').addEventListener('click', () => {
    let human = document.querySelectorAll('.human');
    let social = document.querySelectorAll('.social');
    let edu = document.querySelectorAll('.edu');
    let engine = document.querySelectorAll('.engine');
    let nature = document.querySelectorAll('.nature');
    let medi = document.querySelectorAll('.medi');
    let art = document.querySelectorAll('.art');
    let arr = [human, social, edu, engine, medi, art];
    nature.forEach(elem => {
        elem.style.display = 'block';
    })
    arr.forEach(elems => {
        elems.forEach(elem => {
            elem.style.display = 'none';
        })
    })
})

document.querySelector('.me').addEventListener('click', () => {
    let human = document.querySelectorAll('.human');
    let social = document.querySelectorAll('.social');
    let edu = document.querySelectorAll('.edu');
    let engine = document.querySelectorAll('.engine');
    let nature = document.querySelectorAll('.nature');
    let medi = document.querySelectorAll('.medi');
    let art = document.querySelectorAll('.art');
    let arr = [human, social, edu, engine, nature, art];
    medi.forEach(elem => {
        elem.style.display = 'block';
    })
    arr.forEach(elems => {
        elems.forEach(elem => {
            elem.style.display = 'none';
        })
    })
})

document.querySelector('.ar').addEventListener('click', () => {
    let human = document.querySelectorAll('.human');
    let social = document.querySelectorAll('.social');
    let edu = document.querySelectorAll('.edu');
    let engine = document.querySelectorAll('.engine');
    let nature = document.querySelectorAll('.nature');
    let medi = document.querySelectorAll('.medi');
    let art = document.querySelectorAll('.art');
    let arr = [human, social, edu, engine, nature, medi];
    art.forEach(elem => {
        elem.style.display = 'block';
    })
    arr.forEach(elems => {
        elems.forEach(elem => {
            elem.style.display = 'none';
        })
    })
})