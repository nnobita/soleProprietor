docker build --tag=sole-proprietor:latest --rm=true .
docker run --name=sole-proprietor --publish=8080:8080 sole-proprietor:latest
