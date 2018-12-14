# Attack!!!

## TLDR;

docker container run -v (pwd):/data -e VEGETA_TARGET_URL=172.17.0.1 oba11/vegeta:6.3.0 sh -c "vegeta attack -duration=1m -rate 1 -targets /data/url.list | vegeta report"

## Vegeta?

https://github.com/tsenart/vegeta

## Kustomize

### Doc

<https://github.com/kubernetes-sigs/kustomize>

### Install

```bash
opsys=linux  # or darwin, or windows
curl -s https://api.github.com/repos/kubernetes-sigs/kustomize/releases/latest |\
  grep browser_download |\
  grep $opsys |\
  cut -d '"' -f 4 |\
  xargs curl -O -L
mv kustomize_*_${opsys}_amd64 kustomize
chmod u+x kustomize
```

### Use

- Apply "default" : `kustomize build bases/common/ | kubectl apply -f -`
- Apply "company" : `kustomize build overlays/company/ | kubectl apply -f -`
