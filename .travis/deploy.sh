if [ "$TRAVIS_BRANCH" = "master" ] && [ "$TRAVIS_PULL_REQUEST" = "false" ];
then
    
	./gradlew uploadArchives \
		-PnexusUsername=${SONATYPE_USERNAME} \
		-PnexusPassword=${SONATYPE_PASSWORD}
fi