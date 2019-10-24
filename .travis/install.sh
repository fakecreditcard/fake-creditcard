#if [ "$TRAVIS_BRANCH" = "master" ] && [ "$TRAVIS_PULL_REQUEST" = "false" ];
if [ "$TRAVIS_BRANCH" = "master" ];
then
    openssl aes-256-cbc -K $ENCRYPTED_GPG_KEY_ID_key -iv $ENCRYPTED_GPG_PASSPHRASE_iv -in $ENCRYPTED_GPG_KEY_LOCATION -out $GPG_KEY_LOCATION -d
fi