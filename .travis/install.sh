#if [ "$TRAVIS_BRANCH" = "master" ] && [ "$TRAVIS_PULL_REQUEST" = "false" ];
if [ "$TRAVIS_BRANCH" = "master" ];
then
    openssl aes-256-cbc -K $GPG_KEY_ID -iv $GPG_PASSPHRASE -in $ENCRYPTED_GPG_KEY_LOCATION -out $GPG_KEY_LOCATION -d
fi