
import express from 'express';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
const PORT = process.env.PORT || 3000;

app.use(express.json());
app.use(express.static(path.join(__dirname, 'public')));

// Calculator endpoints
app.post('/api/add', (req, res) => {
  const { a, b } = req.body;
  res.json({ result: Number(a) + Number(b) });
});

app.post('/api/subtract', (req, res) => {
  const { a, b } = req.body;
  res.json({ result: Number(a) - Number(b) });
});

app.post('/api/multiply', (req, res) => {
  const { a, b } = req.body;
  res.json({ result: Number(a) * Number(b) });
});

app.post('/api/divide', (req, res) => {
  const { a, b } = req.body;
  if (Number(b) === 0) {
    return res.status(400).json({ error: 'Division by zero' });
  }
  res.json({ result: Number(a) / Number(b) });
});

app.listen(PORT, () => {
  console.log(`Calculator server running on http://localhost:${PORT}`);
});
