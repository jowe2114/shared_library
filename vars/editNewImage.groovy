def call(String githubToken, String imageName, String gitUserEmail, String gitUserName, String gitRepoName) {
    echo "Editing deployment.yaml with new image: ${imageName}"
    
    // Your logic to update deployment.yaml
    // For example, using a shell script to replace the image in the deployment.yaml file
    sh """
    sed -i 's|image:.*|image: ${imageName}|' path/to/deployment.yaml
    git config user.email "${gitUserEmail}"
    git config user.name "${gitUserName}"
    git add path/to/deployment.yaml
    git commit -m "Update image to ${imageName}"
    git push https://${gitUserName}:${githubToken}@github.com/${gitUserName}/${gitRepoName}.git
    """
}

return this
