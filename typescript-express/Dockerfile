FROM node:18-alpine AS builder

WORKDIR /root/typescript-express

RUN npm install -g npm && \
    npm install -g typescript
COPY *.json ./
COPY src src
RUN npm update && \
    npm run build

# run container
FROM node:18-alpine

ENV NODE_ENV=production
WORKDIR /usr/src/app
RUN apk add --no-cache tini && \
    chown -R node:node .
USER node
COPY package.json .
RUN npm update
COPY --from=builder --chown=node:node /root/typescript-express/lib lib
EXPOSE 8080
ENTRYPOINT ["/sbin/tini", "--", "node", "lib/app.js"]
