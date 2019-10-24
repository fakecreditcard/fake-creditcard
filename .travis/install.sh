#if [ "$TRAVIS_BRANCH" = "master" ] && [ "$TRAVIS_PULL_REQUEST" = "false" ];
if [ "$TRAVIS_BRANCH" = "master" ];
then
    openssl aes-256-cbc -K "$encrypted_77f17bf3ee01_key" -iv "$encrypted_77f17bf3ee01_iv" -in "$ENCRYPTED_GPG_KEY_LOCATION" -out "$GPG_KEY_LOCATION" -d
fi