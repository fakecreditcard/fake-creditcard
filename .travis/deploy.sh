if [ "$TRAVIS_BRANCH" = "master" ] && [ "$TRAVIS_PULL_REQUEST" = "false" ];
then
    #openssl aes-256-cbc -K $encrypted_66ba568ec523_key -iv $encrypted_66ba568ec523_iv -in ${ENCRYPTED_GPG_KEY_LOCATION} -out ${GPG_KEY_LOCATION} -d

	./gradlew uploadArchives \
		-PossrhUsername=${SONATYPE_USERNAME} \
		-PossrhPassword=${SONATYPE_PASSWORD} \
		-Psigning.keyId=${GPG_KEY_ID} \
		-Psigning.password=${GPG_KEY_PASSPHRASE} \
		-Psigning.secretKeyRingFile=${GPG_KEY_LOCATION}
fi