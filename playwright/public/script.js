
let inputExpression = '';
let firstValue = '';
let operator = '';
let waitingForSecondValue = false;

const display = document.getElementById('display');
const buttons = document.querySelector('.buttons');
const clearBtn = document.getElementById('clear');
const equalsBtn = document.getElementById('equals');

buttons.addEventListener('click', async (e) => {
  if (!e.target.classList.contains('btn')) return;
  const value = e.target.dataset.value;
  const op = e.target.dataset.op;

  if (value !== undefined) {
    if (display.textContent === '0' || display.textContent === 'Error' || display.textContent === 'Division by zero') {
      inputExpression = value;
    } else {
      inputExpression += value;
    }
    display.textContent = inputExpression;
  } else if (op) {
    // Prevent multiple operators in a row
    if (operator && waitingForSecondValue) {
      inputExpression = inputExpression.slice(0, -1) + op;
    } else {
      inputExpression += op;
      firstValue = inputExpression.slice(0, inputExpression.length - 1);
      waitingForSecondValue = true;
    }
    operator = op;
    display.textContent = inputExpression;
  }
});

clearBtn.addEventListener('click', () => {
  display.textContent = '0';
  inputExpression = '';
  firstValue = '';
  operator = '';
  waitingForSecondValue = false;
});

equalsBtn.addEventListener('click', async () => {
  if (!operator || firstValue === '' || !waitingForSecondValue) return;
  // Find the second value by splitting the inputExpression at the last operator
  const opIndex = inputExpression.lastIndexOf(operator);
  const secondValue = inputExpression.slice(opIndex + 1);
  let endpoint = '';
  switch (operator) {
    case '+': endpoint = '/api/add'; break;
    case '-': endpoint = '/api/subtract'; break;
    case '*': endpoint = '/api/multiply'; break;
    case '/': endpoint = '/api/divide'; break;
    default: return;
  }
  try {
    const res = await fetch(endpoint, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ a: firstValue, b: secondValue })
    });
    const data = await res.json();
    if (data.result !== undefined) {
      display.textContent = data.result;
      inputExpression = '' + data.result;
    } else if (data.error) {
      display.textContent = data.error;
      inputExpression = '';
    }
    firstValue = '';
    operator = '';
    waitingForSecondValue = false;
  } catch (err) {
    display.textContent = 'Error';
    inputExpression = '';
  }
});
