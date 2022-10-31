#!/bin/bash

echo "====> Installing dependencies..."
npm audit fix

# Get rid of annoying update notifications
npm config set update-notifier false

echo "====> Running test suite..."
npx nodemon --watch '.' -e ts --delay 100ms --exec 'playwright test'