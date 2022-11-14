CONTAINER_NAME=vault-dev
SECRET_ENGINE=stevedev
APPLICATION_NAME=secret-app
PASSWORD=password
VAULT_ADDR=http://localhost
VAULT_PORT=8200
VAULT_URL="$VAULT_ADDR":"${VAULT_PORT}"

docker rm -f "$CONTAINER_NAME"

docker run --cap-add=IPC_LOCK \
  -p 8200:8200 \
  -d \
  --name "$CONTAINER_NAME" \
  -e VAULT_DEV_ROOT_TOKEN_ID="$PASSWORD" \
  -e VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:"$VAULT_PORT" \
  -e VAULT_ADDR="$VAULT_ADDR":"$VAULT_PORT" \
  vault:latest

sleep 2

ENGINE_CONFIG='{
                "type": "kv",
                "description": "Key value storage for '${APPLICATION_NAME}'",
                "options": {
                  "version": "2"
                }
                }'
DEV_SECRETS='{ "data": {"vault.apiKey": "dev-key",
                        "vault.username": "steve-dev",
                        "vault.uuid":"342dd4c7-91f2-48af-b30c-4a2dc1471e67",
                        "vault.password":"dev-password"} }'
PROD_SECRETS='{ "data": {"vault.apiKey": "prod-key",
                         "vault.username": "steve-prod",
                         "vault.uuid":"e3f27978-4205-4a47-975d-4ab9673a8133",
                         "vault.password":"prod-password"} }'

curl --header "X-Vault-Token: $PASSWORD" --request POST --data "${ENGINE_CONFIG}" "${VAULT_URL}"/v1/sys/mounts/"${SECRET_ENGINE}" > /dev/null
curl --header "X-Vault-Token: $PASSWORD" --request POST --data "${DEV_SECRETS}" "${VAULT_URL}"/v1/"${SECRET_ENGINE}"/data/"${APPLICATION_NAME}"/development > /dev/null
curl --header "X-Vault-Token: $PASSWORD" --request POST --data "${PROD_SECRETS}" "${VAULT_URL}"/v1/"${SECRET_ENGINE}"/data/"${APPLICATION_NAME}"/production > /dev/null