# Stage 1: Build
FROM ruby:3.2.2-alpine AS builder

# Install necessary packages
RUN apk add build-base \
  curl \
  git \
  libpq-dev \
  yaml-dev \
  zlib-dev

WORKDIR /app

COPY --chown=rails:rails Gemfile Gemfile.lock ./

# Run Bundler
RUN bundle install

# Stage 2: Run
FROM ruby:3.2.2-alpine
RUN apk update && apk upgrade && apk add \
  curl \
  libpq \
  yaml \
  && rm -rf /var/cache/apk/*

RUN addgroup -S rails && adduser -S -H -G rails rails

WORKDIR /app
COPY --chown=rails:rails . .

COPY --from=builder /usr/local/bundle /usr/local/bundle
COPY --from=builder /app /app

EXPOSE 3000

USER rails

CMD [ "rails", "server", "-b", "0.0.0.0" ]
