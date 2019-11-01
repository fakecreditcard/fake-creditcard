if [ "$TRAVIS_BRANCH" = "master" ] && [ "$TRAVIS_PULL_REQUEST" = "false" ];
then
   chmod u+x gradlew
 
   ./gradlew release -x signArchives

fi