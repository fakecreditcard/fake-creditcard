#if [ "$TRAVIS_BRANCH" = "master" ] && [ "$TRAVIS_PULL_REQUEST" = "false" ];
if [ "$TRAVIS_BRANCH" = "master" ];
then
    openssl aes-256-cbc -K $encrypted_66ba568ec523_key -iv $encrypted_66ba568ec523_iv -in .travis/fakecreditcard.gpg.enc -out .travis/fakecreditcard.gpg -d
fi