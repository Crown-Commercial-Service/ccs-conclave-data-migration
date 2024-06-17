FROM ruby:3.3.3

WORKDIR /app
RUN apt-get update -qq
COPY Gemfile Gemfile.lock ./
RUN bundle install

COPY . .

EXPOSE 3000

CMD ["rails", "server", "-b", "0.0.0.0"]
