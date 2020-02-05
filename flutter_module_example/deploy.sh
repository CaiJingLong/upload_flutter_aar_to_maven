deploy_aar(){
    mvn deploy:deploy-file \
    -DpomFile="$FILE_PATH/$NAME.pom" \
    -DgeneratePom=false \
    -Dfile="$FILE_PATH/$NAME.aar" \
    -Durl="http://localhost:9000/repository/maven-releases" \
    -DrepositoryId="nexus" \
    -Dpackaging=aar \
    -s="mvn-settings.xml" \
    -Dversion="1.0.2"
}

export FILE_PATH="build/host/outputs/repo/com/example/flutter_module_example/flutter_release/1.0/"
export NAME="flutter_release-1.0"
deploy_aar

FILE_PATH="build/host/outputs/repo/io/flutter/plugins/pathprovider/path_provider_release/1.0"
NAME="path_provider_release-1.0"
deploy_aar