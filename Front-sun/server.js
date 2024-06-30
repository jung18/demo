import { fileURLToPath } from 'url';
import { dirname } from 'path';
import { createRequire } from 'module'; // Only for older Node.js versions

const require = createRequire(import.meta.url);

const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);

import express from 'express';
import path from 'path';
import process from 'process'; // Import process explicitly

const app = express();

// Middleware to set COOP and COEP headers
app.use((req, res, next) => {
  res.setHeader('Cross-Origin-Opener-Policy', 'same-origin');
  res.setHeader('Cross-Origin-Embedder-Policy', 'require-corp');
  next();
});

// Serve static files from the React app
app.use(express.static(path.join(__dirname, 'build')));

app.get('*', (req, res) => {
  res.sendFile(path.join(__dirname, 'build', 'index.html'));
});

const PORT = process.env.PORT || 1573; // Use process.env.PORT
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});