# Attack!!!

## TLDR;

docker container run -v (pwd):/data -e VEGETA_TARGET_URL=172.17.0.1 oba11/vegeta:6.3.0 sh -c "vegeta attack -duration=1m -rate 1 -targets /data/url.list | vegeta report"

## Vegeta?

https://github.com/tsenart/vegeta

