# Data Migration API

## Table of Contents
1. [About](#about)
2. [Tech Stack](#tech-stack)
3. [Prerequisites](#prerequisites)
4. [Installation & Run](#installation--run)
5. [Other Notes](#other-notes)
6. [Changelog](#changelog)
7. [Support](#support)

## About
Data Migration API, that supports the migration of both organisation and user data into the PPG SSO system. Data provided to the request body as either a CSV file in the header, or a JSON body.


## Tech Stack
- [Ruby](https://www.ruby-lang.org/)
- [Rails](https://rubyonrails.org/)
- [PostgreSQL](https://www.postgresql.org/)


## Prerequisites
To get started with this project, you need to have the following installed on your machine:

1. **Ruby**:
    - Check if Ruby is installed:
      ```sh
      ruby -v
      ```
    - Install Ruby (if not already installed):
      - **Windows**: Use [RubyInstaller](https://rubyinstaller.org/)
      - **macOS**: Use Homebrew
        ```sh
        brew install ruby
        ```
      - **Linux**: Use the package manager specific to your distribution, e.g.,
        ```sh
        sudo apt-get install ruby-full
        ```
2. **Rails**:
    - Check if Rails is installed:
      ```sh
      rails -v
      ```
    - Install Rails (if not already installed):
      ```sh
      gem install rails
      ```
3. **PostgreSQL**:
    - Check if PostgreSQL is installed:
      ```sh
      psql --version
      ```
    - Install PostgreSQL (if not already installed):
      - **Windows**: Use [PostgreSQL Installer](https://www.postgresql.org/download/windows/)
      - **macOS**: Use Homebrew
        ```sh
        brew install postgresql
        ```
      - **Linux**: Use the package manager specific to your distribution, e.g.,
        ```sh
        sudo apt-get install postgresql postgresql-contrib
        ```


## Installation & Run
Follow these steps to set up and run the project locally:

1. Clone the repository:
    ```sh
    git clone https://github.com/Crown-Commercial-Service/ccs-conclave-data-migration
    cd ccs-conclave-data-migration
    ```
2. Set your Ruby version to 3.3.3:
    ```sh
    rbenv install 3.3.3
    rbenv local 3.3.3
    ```
3. Install the required gems:
    ```sh
    bundle install
    ```
4. Set up the database:
    ```sh
    rails db:create
    rails db:migrate
    rails db:seed
    ```
5. Start the Rails server:
    ```sh
    rails s
    ```
6. Send requests to `http://localhost:3000/...`


## Other Notes
- Lorem ipsum dolor sit amet, consectetur adipiscing elit.


## Changelog
| Date       | Version | Changes                                    |
|------------|---------|--------------------------------------------|
| 2024-07-15 | 0.9.0   | Initial release                            |
| 2024-07-20 | 0.9.1   | Fixed minor bugs and updated documentation |


## Support
Developers: 
- Tom Berey.
- PPG Team.

For any help, support or queries, feel free to reach out.
