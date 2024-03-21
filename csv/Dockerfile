FROM ruby:3.2.2

WORKDIR /app
RUN apt-get update -qq
COPY csv/Gemfile csv/Gemfile.lock ./
RUN bundle install

COPY csv .

EXPOSE 3000

CMD ["rails", "server", "-b", "0.0.0.0"]